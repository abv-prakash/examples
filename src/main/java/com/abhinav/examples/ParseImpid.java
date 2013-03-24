package com.abhinav.examples;

import java.util.UUID;


/**
 * @author abhinav.prakash
 * 
 */
public class ParseImpid
{
    /*
     * Reversing the data center id so that the unused bits can be used by the cyclic counter. Need to convert byte to
     * int before reversal.
     */
    public static byte getDataCenterId(final String uuid)
    {
        UUID u = UUID.fromString(uuid);
        long lsig = u.getLeastSignificantBits();
        /*
         * lsig & 0xfe will fetch 7 bits of dc id. Now since 2 bits of dc id is used by the cyclic counter, we should
         * not be reading these bits. Hence do lsig & 0xf8
         */
        // byte revDCId = (byte) ((lsig & 0xfe) >> 1);
        byte revDCId = (byte) ((lsig & 0xf8) >> 1);
        int dcIdInt = revDCId << 25;
        byte dcId = (byte) (Integer.reverse(dcIdInt));
        return dcId;
    }

    /**
     * @param args
     */
    public static void main(final String[] args)
    {
        System.out.println(getDataCenterId("ecd79536-013c-1000-e561-401d1ec50065"));
    }

}
