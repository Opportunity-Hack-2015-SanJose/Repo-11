package com.samaritan.externalAPIs;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
 
import java.util.ArrayList;
import java.util.List;
 
public class SMSIntegration {
 
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC13ba191e635e9e3fe92e2596057bbdd3";
  public static final String AUTH_TOKEN = "d66f998635392fb4018584f6efae5497";
 
  public void secureSMS() throws TwilioRestException {
    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 
    // Build a filter for the MessageList
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("Body", "Hi!!"));
    params.add(new BasicNameValuePair("To", "+15105169761"));
    params.add(new BasicNameValuePair("From", "+14152149002"));
 
    MessageFactory messageFactory = client.getAccount().getMessageFactory();
    Message message = messageFactory.create(params);
    System.out.println(message.getSid());
  }
}
