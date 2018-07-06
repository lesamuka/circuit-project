package br.facebookmediamarkt.facebook.facebook4j;

import br.facebookmediamarkt.facebook.token.Token;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;

public class Facebook4j extends Token {

    public static void main(String[] args) throws FacebookException, MalformedURLException {
        ConfigurationBuilder cf = new ConfigurationBuilder();
        cf.setDebugEnabled(true);
        // cb.setClientVersion("v2.2");
//        cf.setOAuthAppId(appID);
//        cf.setOAuthAppSecret(appSecretKey);
//        cf.setOAuthAccessToken(tok);
        //cb.setOAuthPermissions("user_birthday, user_religion_politics, user_relationships, user_relationship_details, user_hometown, user_location, user_likes, user_education_history, user_work_history, user_website, user_managed_groups, user_events, user_photos, user_videos, user_friends, user_about_me, user_status, user_games_activity, user_tagged_places, user_posts, read_page_mailboxes, rsvp_event, email, ads_management, ads_read, read_insights, manage_pages, publish_pages, pages_show_list, pages_manage_cta, pages_manage_instant_articles, business_management, pages_messaging, pages_messaging_phone_number, pages_messaging_subscriptions, pages_messaging_payments, publish_actions, read_audience_network_insights, read_custom_friendlists, user_actions.music, user_actions.video, user_actions.news, user_actions.fitness, user_actions.books, public_profile");
        cf.setUseSSL(true);
        cf.setJSONStoreEnabled(true);

        Configuration configuration = cf.build();

        FacebookFactory facebookFactory = new FacebookFactory();

        Facebook facebook = facebookFactory.getInstance();
        facebook.setOAuthAppId(appID, appSecretKey);
        facebook.setOAuthAccessToken(new AccessToken(tok));

//         String results = getFacebookPostes(facebook);
//        facebook.postStatusMessage("Wow, it works...");
//        for (int i = 0; i <= 1000; i++) {
//            facebook.commentPost("100001495856772_1304921192901063", "for (int i = 0; "+ i + " <= 1000; i++)");
//        }
        PostUpdate post = new PostUpdate("aaaaaaaaaa")
                .picture(new URL("http://revistagalileu.globo.com/Revista/Galileu2/foto/0,,69821488,00.jpg"))
                .link(new URL("http://Exemplo.sk"))
                .name("Exemplo")
                .caption("Exemplo")
                .message("Exemplo")
                .description("Exemplo");

        facebook.postFeed(post);
    }

    public static String getFacebookPostes(Facebook facebook) throws FacebookException {
        Post post = facebook.getPost("100001495856772_1304921192901063");

        System.out.println(post);

        return post.toString();
    }
}
