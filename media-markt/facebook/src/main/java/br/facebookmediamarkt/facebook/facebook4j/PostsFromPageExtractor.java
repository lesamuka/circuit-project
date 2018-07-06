package br.facebookmediamarkt.facebook.facebook4j;

import br.facebookmediamarkt.facebook.token.Token;
import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class PostsFromPageExtractor extends Token {

    public static void main(String[] args) throws FacebookException {

        // Generate facebook instance.
        Facebook facebook = new FacebookFactory().getInstance();
        // Use default values for oauth app id.
        facebook.setOAuthAppId(appID, appSecretKey);
        // Get an access token from: 
        // https://developers.facebook.com/tools/explorer
        // Copy and paste it below.

        AccessToken at = new AccessToken(tok);
        // Set access token.
        facebook.setOAuthAccessToken(at);

        // We're done.
        // Access group feeds.
        // You can get the group ID from:
        // https://developers.facebook.com/tools/explorer
        // Set limit to 25 feeds.
        ResponseList<Post> feeds = facebook.getFeed("me", new Reading().limit(25));

        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
            // Print out the message.
            System.out.println(message);

            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();

            System.out.println(date);
            System.out.println(name);
            System.out.println(id);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();

        }
    }

}
