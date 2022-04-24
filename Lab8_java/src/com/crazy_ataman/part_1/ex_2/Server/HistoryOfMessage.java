package com.crazy_ataman.part_1.ex_2.Server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class HistoryOfMessage {
    private final LinkedList<String> historyOfMessage=new LinkedList<>();

    public void addHistoryElement(String message){
        if(historyOfMessage.size() >=10){
            historyOfMessage.removeFirst();
        }
        historyOfMessage.add(message);
    }

    public void printHistory(BufferedWriter writer){
        if(historyOfMessage.size()>0){
            try{
                writer.write("____________________________\n");
                writer.write("History messages\n");
                for(String vr : historyOfMessage){
                    writer.write(vr+"\n");
                }
                writer.write("____________________________\n");
                writer.flush();
            }
            catch (IOException ignored) { }
        }
    }
}
