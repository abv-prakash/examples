package com.abhinav.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;


public class RegEx
{

    private static final long LEAST_8_BITS_MASK = 0x00000000000000ffL; // Least 8 bits mask
    private static final long MID_16_BITS_MASK  = 0x0000000000ffff00L; // Mid 16 bits mask for integer
    private static final long HIGH_8_BITS_MASK  = 0x00000000ff000000L; // Highest 8 bits mask for integer

    public static boolean matchesRegex(final String inputString, final String regex)
    {
        Pattern pattern = Pattern.compile(regex);
        System.out.println("String:" + inputString + "Pattern:" + pattern);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find())
        {
            System.out.println("Matcher :+" + matcher);
            System.out.println("group 1 :" + matcher.group(0));
            System.out.println("group 2 :" + matcher.group(1));
            System.out.println("group 3 :" + matcher.group(2));

            String ad_id_hex = matcher.group(2) + matcher.group(1) + matcher.group(0);
            Integer ad_inc_id = Integer.parseInt(ad_id_hex, 16);
            byte[] ad_inc_id2 = null;
            try
            {
                ad_inc_id2 = Hex.decodeHex(ad_id_hex.toCharArray());
            }
            catch (DecoderException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Ad INc ID: " + ad_inc_id);
            return true;
        }
        else
        {
            System.out.println("NO MATCH FOR IMPID");
            return false;
        }
    }

    public static int getIntKey(final String uuid)
    {
        UUID u = UUID.fromString(uuid);
        long lsig = u.getLeastSignificantBits();

        int key = (int) (((lsig >> 48) & LEAST_8_BITS_MASK) | ((lsig >> 8) & MID_16_BITS_MASK) | ((lsig << 16) & HIGH_8_BITS_MASK));
        return key;
    }

    public static void checkReplace()
    {

        Object impid = "    \"  84fbcfcc-0139-1000-f28b-3eb21ad60044    \"      ";
        System.out.println("before:" + impid);
        String newimpid = impid.toString().replaceAll("\"", "").trim();
        System.out.println("after:" + newimpid);

        String str = " Rose India";
        System.out.println("before:" + str);
        System.out.println("after:" + str.trim());

    }

    public static void testStringRegex()
    {
        String regex = "(.*)(\\.)doubleclick(\\.)net";

        Pattern pattern = Pattern.compile(regex);

        String testString = "http://ad.mo.doubleclick.net/inmobitracker/click/phoenix?c=4176&sub1=$iat_fw_cinfo";

        URL landingUrl = null;
        try
        {
            landingUrl = new URL(testString);
        }
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String host = landingUrl.getHost();
        System.out.println("host:" + host);

        Matcher matcher = pattern.matcher(host);

        System.out.println("matcher :" + matcher);
        if (matcher.matches())
        {
            System.out.println("matcher :" + matcher.group());
        }

    }

    public static void main(final String args[])
    {
        testStringRegex();

        // String to be scanned to find the pattern.

        checkReplace();

        String line = "This order was places for QT3000! OK?";
        String pattern = "(.*)(\\d+)(.*)";

        Object impid = "84fbcfcc-0139-1000-f28b-3eb21ad60044";
        int adincId = getIntKey(impid.toString());
        System.out.println("Ad INc ID: " + adincId);

        String impidPattern = "(\\d|\\w{2})-?\\d|\\w{4}(\\d|\\w{4})(\\d|\\w{2})\\d|\\w{2}$";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find())
        {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
        }
        else
        {
            System.out.println("NO MATCH");
        }

        // matchesRegex(impid, impidPattern);
    }

}