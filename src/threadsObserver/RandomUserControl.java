package threadsObserver;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends Observable implements Runnable {

    public void fetchRandomUser() {
        RandomUser user = null;
            try {
                user = RandomUserGenerator.getRandomUser();
            } catch (InterruptedException ex) {
                Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            setChanged();
            notifyObservers(user);
    }

    @Override
    public void run() {
        fetchRandomUser();
    }

    
}



//  COMMENTS
//
//  When and why we will use Threads in our programs?
//  Når man vil udnytte at man kan arbejde på flere kerner (og dermed kører flere metoder på samme tid).
//  Det gør også at programmer kan arbejde med nogle tungere ting i baggrunden, mens andre metoder kører.
//
//  Explain about the Race Condition Problem and ways to solve it in Java
//  Race Conditionen opstår når to tråde kører og bruger samme variabler uden at tage hensyn til at den måske bliver tilgået/ændret af en anden tråd (se Even opgaven).
//  Syncronize gør at det kun er een tråd der har adgang til en variable eller metode af gangen. Alternativt kan man også bruge lock for at låse den del af metoden
//  (eller hele metoden) som man vil have at kun een tråd har adgang til af gangen. 
//
//  Explain how Threads can help us in making responsive User Interfaces
//  Hvis man bruger tråde, kan man lade flere tråde stå for afviklingen af programmet, så man ikke oplever et lack i User Interfaces. F.eks. denne opgave.
//
//  Explain how we can write reusable non-blocking Java Controls using Threads and the observer Pattern
//
//
//
