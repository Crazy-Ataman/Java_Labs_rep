package com.crazy_ataman.part_1.ex_1;

public class Main {

    public static void main(String[] args) {
	    var connection=new InternetConnection();
        connection.getLocalHost();
        connection.getByName("www.belstu.by");
        // Reserved IP address.
        // Used for special purposes such as software, private networks and so on.
        byte[] ip={(byte) 127,(byte) 0, (byte) 0, (byte) 7};
        connection.getByAddress("Unknown", ip);
        connection.readHTML("https://github.com");
        connection.getInfo("https://myfin.by");
    }
}
