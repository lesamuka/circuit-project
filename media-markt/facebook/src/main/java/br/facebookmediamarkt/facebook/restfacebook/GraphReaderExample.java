package br.facebookmediamarkt.facebook.restfacebook;

import br.facebookmediamarkt.facebook.token.Token;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.DefaultJsonMapper;
import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.JsonMapper;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonArray;
import com.restfb.json.JsonObject;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.Url;
import facebook4j.User;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphReaderExample extends Token {
    //https://github.com/restfb/restfb-examples/tree/master/src/main/java/com/restfb/example

    /**
     * RestFB Graph API client.
     */
    private final FacebookClient facebookClient23;
    private final FacebookClient facebookClient20;

    /**
     * Entry point. You must provide a single argument on the command line: a
     * valid Graph API access token.
     *
     * @param args Command-line arguments.
     * @throws IllegalArgumentException If no command-line arguments are
     * provided.
     */
    public static void main(String[] args) {
        new GraphReaderExample(tok).runEverything();
    }

    GraphReaderExample(String accessToken) {
        facebookClient23 = new DefaultFacebookClient(accessToken, Version.VERSION_2_3);
        facebookClient20 = new DefaultFacebookClient(accessToken, Version.VERSION_2_2);
    }

    void runEverything() {
        fetchObject();
        fetchObjects();
        fetchObjectsAsJsonObject();
        fetchConnections();
        fetchDifferentDataTypesAsJsonObject();
        query();
        multiquery();
        search();
        metadata();
        paging();
        selection();
        parameters();
        rawJsonResponse();
    }

    void fetchObject() {
        System.out.println("* Fetching single objects *");

        User user = facebookClient23.fetchObject("me", User.class);
        Page page = facebookClient23.fetchObject("cocacola", Page.class);

        System.out.println("User name: " + user.getName());
        System.out.println("Page likes: " + page.getLikes());
    }

    void fetchObjectsAsJsonObject() {
        System.out.println("* Fetching multiple objects at once as a JsonObject *");

        List<String> ids = new ArrayList<String>();
        ids.add("4");
        ids.add("http://www.imdb.com/title/tt0117500/");

        // Make the API call
        JsonObject results = facebookClient23.fetchObjects(ids, JsonObject.class);

        System.out.println(results.toString());

        // Pull out JSON data by key and map each type by hand.
        JsonMapper jsonMapper = new DefaultJsonMapper();
//        User user = jsonMapper.toJavaObject(results.getString("4"), User.class);

        Url url = jsonMapper.toJavaObject(results.get("http://www.imdb.com/title/tt0117500/").toString(), Url.class);

//        System.out.println("User is " + user);
        System.out.println("URL is " + url);
    }

    void fetchObjects() {
        System.out.println("* Fetching multiple objects at once *");

        FetchObjectsResults fetchObjectsResults
                = facebookClient23.fetchObjects(Arrays.asList("me", "cocacola"), FetchObjectsResults.class);

        System.out.println("User name: " + fetchObjectsResults.me.getName());
        System.out.println("Page likes: " + fetchObjectsResults.page.getLikes());
    }

    void fetchDifferentDataTypesAsJsonObject() {
        System.out.println("* Fetching different types of data as JsonObject *");

        JsonObject zuck = facebookClient23.fetchObject("4", JsonObject.class);
        System.out.println(zuck);

        JsonObject photosConnection = facebookClient23.fetchObject("me/photos", JsonObject.class);
        JsonArray photosConnectionData = photosConnection.asArray();

        if (photosConnectionData.isNull()) {
            String firstPhotoUrl = photosConnectionData.get(0).toString();
            System.out.println(firstPhotoUrl);
        }

        String query = "SELECT uid, name FROM user WHERE uid=4 or uid=11";
        List<JsonObject> queryResults = facebookClient20.executeFqlQuery(query, JsonObject.class);

        if (!queryResults.isEmpty()) {
            System.out.println(queryResults.get(0));
        }
    }

    /**
     * Holds results from a "fetchObjects" call.
     */
    public static class FetchObjectsResults {

        @Facebook
        User me;

        @Facebook(value = "cocacola")
        Page page;
    }

    void fetchConnections() {
        System.out.println("* Fetching connections *");

        Connection<User> myFriends = facebookClient23.fetchConnection("me/friends", User.class);
        Connection<Post> myFeed = facebookClient23.fetchConnection("me/feed", Post.class);

        System.out.println("Count of my friends: " + myFriends.getData().size());

        if (!myFeed.getData().isEmpty()) {
            System.out.println("First item in my feed: " + myFeed.getData().get(0).getMessage());
        }
    }

    void query() {
        System.out.println("* FQL Query *");

        List<FqlUser> users
                = facebookClient20.executeFqlQuery("SELECT uid, name FROM user WHERE uid=4 or uid=11", FqlUser.class);

        System.out.println("User: " + users);
    }

    void multiquery() {
        System.out.println("* FQL Multiquery *");

        Map<String, String> queries = new HashMap<String, String>();
        queries.put("users", "SELECT uid, name FROM user WHERE uid=4 OR uid=11");
        queries.put("likers", "SELECT user_id FROM like WHERE object_id=122788341354");

        MultiqueryResults multiqueryResults = facebookClient20.executeFqlMultiquery(queries, MultiqueryResults.class);

        System.out.println("Users: " + multiqueryResults.users);
        System.out.println("People who liked: " + multiqueryResults.likers);
    }

    /**
     * Holds results from an "executeQuery" call.
     * <p>
     * Be aware that FQL fields don't always map to Graph API Object fields.
     */
    public static class FqlUser {

        @Facebook
        String uid;

        @Facebook
        String name;

        @Override
        public String toString() {
            return format("%s (%s)", name, uid);
        }
    }

    /**
     * Holds results from an "executeQuery" call.
     * <p>
     * Be aware that FQL fields don't always map to Graph API Object fields.
     */
    public static class FqlLiker {

        @Facebook("user_id")
        String userId;

        @Override
        public String toString() {
            return userId;
        }
    }

    /**
     * Holds results from a "multiquery" call.
     */
    public static class MultiqueryResults {

        @Facebook
        List<FqlUser> users;

        @Facebook
        List<FqlLiker> likers;
    }

    void search() {
        System.out.println("* Searching connections *");

        // Connection<Post> publicSearch =
        // facebookClient23.fetchConnection("search", Post.class, Parameter.with("q", "watermelon"),
        // Parameter.with("type", "post"));
        Connection<User> targetedSearch = facebookClient23.fetchConnection("search", User.class,
                Parameter.with("q", "Mark"), Parameter.with("type", "user"));

        // if (publicSearch.getData().size() > 0)
        // out.println("Public search: " + publicSearch.getData().get(0).getMessage());
        System.out.println("Posts on my wall by friends named Mark: " + targetedSearch.getData().size());
    }

    void metadata() {
        System.out.println("* Metadata *");

        User userWithMetadata = facebookClient23.fetchObject("me", User.class, Parameter.with("metadata", 1));

        System.out.println("User metadata: has albums? " + userWithMetadata.getMetadata().getConnections());
    }

    void paging() {
        System.out.println("* Paging support *");

        Connection<User> myFriends = facebookClient23.fetchConnection("me/friends", User.class);
        Connection<Post> myFeed = facebookClient23.fetchConnection("me/feed", Post.class, Parameter.with("limit", 100));

        System.out.println("Count of my friends: " + myFriends.getData().size());

        if (!myFeed.getData().isEmpty()) {
            System.out.println("First item in my feed: " + myFeed.getData().get(0));
        }

        for (List<Post> myFeedConnectionPage : myFeed) {
            for (Post post : myFeedConnectionPage) {
                System.out.println("Post from my feed: " + post);
            }
        }
    }

    void selection() {
        System.out.println("* Selecting specific fields *");

        User user = facebookClient23.fetchObject("me", User.class, Parameter.with("fields", "id,name"));

        System.out.println("User name: " + user.getName());
    }

    void parameters() {
        System.out.println("* Parameter support *");

        Date oneWeekAgo = new Date(currentTimeMillis() - 1000L * 60L * 60L * 24L * 7L);

        Connection<Post> filteredFeed = facebookClient23.fetchConnection("me/feed", Post.class, Parameter.with("limit", 3),
                Parameter.with("until", "yesterday"), Parameter.with("since", oneWeekAgo));

        System.out.println("Filtered feed count: " + filteredFeed.getData().size());
    }

    void rawJsonResponse() {
        System.out.println("* Raw JSON *");
        System.out.println("User object JSON: " + facebookClient23.fetchObject("me", String.class));
    }
}
