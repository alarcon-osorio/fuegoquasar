<<<<<<< HEAD
package com.alianza.rebelde.service;

import com.alianza.rebelde.excepciones.MessageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MessageService {

    public List<String> getPhrase(List<List<String>> messageList){
        List<String> words = new ArrayList<String>();
        for( List<String> message : messageList){
            words = Stream.concat(words.stream(), message.stream())
                    .distinct()
                    .collect(Collectors.toList());
        }
        words.remove("");
        return words;
    }

    public void removeDistance(List<List<String>> messageList, int space){
        int s = 0;
        for(int i = 0; i < messageList.size(); i++){
            s = messageList.get(i).size();
            messageList.set(i, messageList.get(i).subList(s-space, s));
        }
    }

    public String messageComplete(List<List<String>> messageList){
        String phrase = "";
        for(List<String> message : messageList){
            if(message.size()>0 && !message.get(0).equals("")){
                phrase = (message.size() == 1) ? message.get(0) : message.get(0) + " ";
                messageList.stream().forEach( s -> s.remove(0));
                return  phrase + messageComplete(messageList);
            }
        }
        return "";
    }

    public String getMessage(List<List<String>> messageList) throws MessageException {
        List<String> messagePhrase = getPhrase(messageList);
        if(!sizeMessage(messageList, messagePhrase.size()))
            throw new MessageException("Tamaño del mensaje incorrecto");

        removeDistance(messageList,messagePhrase.size());
        String message = messageComplete(messageList);
        if(!messagePhrases(messagePhrase,message))
            throw new MessageException("No se puede conocer el mensaje");

        return message;
    }


    public boolean sizeMessage(List<List<String>> messages, int size){
        for(List<String> message : messages){
            if(message.size() < size){
                return false;
            }
        }
        return true;
    }

    public boolean messagePhrases(List<String> phrases, String messages){
        List<String> message = Arrays.stream(messages.split(" ")).collect(Collectors.toList());
        Collections.sort(phrases);
        Collections.sort(message);
        return Arrays.equals(phrases.toArray(), message.toArray());
    }

}
=======
package com.alianza.rebelde.service;

import com.alianza.rebelde.excepciones.MessageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MessageService {

    public List<String> getPhrase(List<List<String>> messageList){
        List<String> words = new ArrayList<String>();
        for( List<String> message : messageList){
            words = Stream.concat(words.stream(), message.stream())
                    .distinct()
                    .collect(Collectors.toList());
        }
        words.remove("");
        return words;
    }

    public void removeDistance(List<List<String>> messageList, int space){
        int s = 0;
        for(int i = 0; i < messageList.size(); i++){
            s = messageList.get(i).size();
            messageList.set(i, messageList.get(i).subList(s-space, s));
        }
    }

    public String messageComplete(List<List<String>> messageList){
        String phrase = "";
        for(List<String> message : messageList){
            if(message.size()>0 && !message.get(0).equals("")){
                phrase = (message.size() == 1) ? message.get(0) : message.get(0) + " ";
                messageList.stream().forEach( s -> s.remove(0));
                return  phrase + messageComplete(messageList);
            }
        }
        return "";
    }

    public String getMessage(List<List<String>> messageList) throws MessageException {
        List<String> messagePhrase = getPhrase(messageList);
        if(!sizeMessage(messageList, messagePhrase.size()))
            throw new MessageException("Tamaño del mensaje incorrecto");

        removeDistance(messageList,messagePhrase.size());
        String message = messageComplete(messageList);
        if(!messagePhrases(messagePhrase,message))
            throw new MessageException("No se puede conocer el mensaje");

        return message;
    }


    public boolean sizeMessage(List<List<String>> messages, int size){
        for(List<String> message : messages){
            if(message.size() < size){
                return false;
            }
        }
        return true;
    }

    public boolean messagePhrases(List<String> phrases, String messages){
        List<String> message = Arrays.stream(messages.split(" ")).collect(Collectors.toList());
        Collections.sort(phrases);
        Collections.sort(message);
        return Arrays.equals(phrases.toArray(), message.toArray());
    }

}
>>>>>>> fe4517c239007c4df640d8b5283375c16a638e21
