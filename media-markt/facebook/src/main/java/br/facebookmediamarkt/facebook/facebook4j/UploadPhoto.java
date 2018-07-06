package br.facebookmediamarkt.facebook.facebook4j;

import br.facebookmediamarkt.facebook.token.Token;
import facebook4j.BatchAttachment;
import facebook4j.BatchRequest;
import facebook4j.BatchRequests;
import facebook4j.BatchResponse;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Media;
import facebook4j.auth.AccessToken;
import facebook4j.internal.http.RequestMethod;
import java.io.File;
import java.util.List;

public class UploadPhoto extends Token {

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

        BatchRequests<BatchRequest> batch = new BatchRequests<>();

        Media media = new Media(new File("//home//alci//Desenvolvimento//Projeto//GitHub//Projetos-Base//Facebook4j//src//main//resources//explosaosolar.jpg"));

        BatchAttachment attachment = new BatchAttachment("file", media);

        BatchRequest attachedFile = new BatchRequest(RequestMethod.POST, "me/photos");
        attachedFile.body("message=My photo");
        attachedFile.attachedFile(attachment);

        batch.add(attachedFile);

        List<BatchResponse> executeBatch = facebook.executeBatch(batch);
    }
}
