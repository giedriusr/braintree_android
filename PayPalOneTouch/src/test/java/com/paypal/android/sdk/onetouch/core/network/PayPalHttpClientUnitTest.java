package com.paypal.android.sdk.onetouch.core.network;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.io.IOException;
import java.net.HttpURLConnection;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class PayPalHttpClientUnitTest {

    @Test
    public void setsUserAgent() throws IOException {
        PayPalHttpClient httpClient = new PayPalHttpClient();

        HttpURLConnection connection = httpClient.init("http://example.com");

        assertEquals(OtcEnvironment.getUserAgent(),
                connection.getRequestProperty("User-Agent"));
    }

    @Test
    public void setsConnectTimeout() throws IOException {
        PayPalHttpClient httpClient = new PayPalHttpClient();

        HttpURLConnection connection = httpClient.init("http://example.com");

        assertEquals(90000, connection.getConnectTimeout());
    }
}
