package source;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class is the main class of the "World of Zuul" application. "World of
 * Zuul" is a very simple, text based adventure game. Users can walk around some
 * scenery. That's all. It should really be extended to make it more
 * interesting!
 *
 * To play this game, create an instance of this class and call the "play"
 * method.
 *
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */
class Game {

    private Parser parser;
    private Room currentRoom, outside, theatre, pub, lab, office, attic, basement;
    private boolean search, gotKey = false;

    Scanner input = new Scanner(System.in);

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {

        // create the rooms and initialise room exits
        outside = new Room("outside the main entrance of the university.", "The night is cold and the moon is full.",
                "", "lab", "theatre", "pub", "", "");

        theatre = new Room("in a lecture theatre.", "All the chairs are empty and some windows are broken.",
                "", "", "", "outside", "", "");
        Item guy = new Item("a strange looking guy", " in the corner staring at you. Booooh! Maybe you should run away...");
        theatre.addItem(guy);

        pub = new Room("in the campus pub.", "There are empty bottles on the floor and a broken broom behind the counter.",
                "", "", "outside", "", "", "");
        Item chestKey = new Item("a mysterious key.", " I wander what is it for...");
        pub.addItem(chestKey);

        lab = new Room("in a computing lab.", "There is only one computer working. It is open to a random website about snails...",
                "outside", "", "office", "", "", "");
        Item soda = new Item("a soda.", " It looks very tasty!");
        lab.addItem(soda);

        office = new Room("in the computing admin office.", "There is pretty much nothing here. Just a bunch of messy books. I wonder if the developper ran out of ideias...",
                "", "", "", "lab", "attic", "basement");

        //INSTANCIANDO NOVOS QUARTOS (PORAO E SOTAO)
        attic = new Room("in a cold attic.", "The ceiling is full of spider webs.",
                "", "", "", "", "", "office");
        Item rabbit = new Item("a rabbit.", " It looks so cute.");
        attic.addItem(rabbit);

        basement = new Room("in a silent and messy basement.", "There are cardboard boxes in the shelfs and some paitings hanging on the walls.",
                "", "", "", "", "office", "");
        Item chest = new Item("an old and dusty chest.", " You need a key to open it.");
        basement.addItem(chest);

        //PARTE DO PROGRAMA ANTERIOR QUE FOI OTIMIZADA
        /*
        outside.setExits(null, theatre, lab, pub, null, null);
        theatre.setExits(null, null, null, outside, null, null);
        pub.setExits(null, outside, null, null, null, null);
        lab.setExits(outside, office, null, null, null, null);
        office.setExits(null, null, null, lab, attic, basement);
        attic.setExits(null, null, null, null, null, office);
        basement.setExits(null, null, null, null, office, null);
         */
        currentRoom = outside;  // start game outside
        search = false; //COMECA O JOGO SEM SABER OS DETALHES DE ONDE ESTA
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to Adventure!");
        System.out.println("Adventure is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");

    }

    private void printExits() {

        // CRIAR MÉTODO PARA OTIMIZAR EVITAR REPETIÇÃO DE CODIGO
        System.out.print("Exits: ");

        for (String key : currentRoom.getMap().keySet()) {
            if (!currentRoom.getMap().get(key).equals("")) {
                System.out.print(key + " ");
            }
        }

        /*
        if(!"".equals(currentRoom.getMap().get("north"))) {
            System.out.print("north ");
        }

        if (!"".equals(currentRoom.getMap().get("east"))) {
            System.out.print("east ");
        }

        if (!"".equals(currentRoom.getMap().get("south"))) {
            System.out.print("south ");
        }

        if (!"".equals(currentRoom.getMap().get("west"))) {
            System.out.print("west ");
        }

        //ADICIONAMOS AS OPCOES DE SAIDAS PARA CIMA E PARA BAIXO
        if (!"".equals(currentRoom.getMap().get("downstairs"))) {
            System.out.println("downstairs ");
        }
        if (!"".equals(currentRoom.getMap().get("upstairs"))) {
            System.out.println("upstairs ");
        }
         */
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command. If this command
     * ends the game, true is returned, otherwise false is returned.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        switch (commandWord) {
            case "help":
                printHelp(command);
                break;
            case "go":
                goRoom(command);
                break;
            case "quit":
                wantToQuit = quit(command);
                break;
            case "seek":
                seek(currentRoom, command.hasSecondWord());
                break;
            case "eat":
                System.out.println("You ate and you're not hungry anymore.");
                break;
            default:
                break;
        }

        return wantToQuit;
    }

    // implementations of user commands:
    /**
     * Print out some help information. Here we print some stupid, cryptic
     * message and a list of the command words.
     */
    private void printHelp(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("You are lost. You are alone. You wander");
            System.out.println("around at the university.");
            System.out.println();
            System.out.println("Your command words are:");

            //ALTERAMOS A FORMA DE IMPRIMIR AS OPÇOES (ITEM 7) PARA QUE
            System.out.println(Arrays.toString(CommandWords.getValidCommands()));
        } else {
            System.out.println("Want help with something? Type 'help' ");
        }

    }

    private void printCurrentRoomDescription() {
        System.out.println("You are " + currentRoom.getRoomDescription());

        for (Item objectItem : currentRoom.getRoomItem()) {
            System.out.println("You find " + objectItem.getName() + objectItem.getItemDescription());
        }
    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    private void goRoom(Command command) {
        /*ADICIONAR CONDICAO PARA QUE O PERSONAGEM SO POSSA MUDAR DE QUARTO 
        SE JA TIVER INVESTIGADO O LOCAL PARA DESCOBRIR AS SAIDAS
         */
        if (search) {

            if (!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Go where?");
                return;
            }

            String direction = command.getSecondWord();

            // Try to leave current room.
            String nextRoom = "";

            for (String tmp : currentRoom.getMap().keySet()) {
                if (direction.equals(tmp)) {
                    nextRoom = currentRoom.getMap().get(tmp);
                }
            }
            if (nextRoom.equals("outside")) {
                currentRoom = outside;
            }
            if (nextRoom.equals("lab")) {
                currentRoom = lab;
            }
            if (nextRoom.equals("theatre")) {
                currentRoom = theatre;
            }
            if (nextRoom.equals("pub")) {
                currentRoom = pub;
            }
            if (nextRoom.equals("office")) {
                currentRoom = office;
            }
            if (nextRoom.equals("attic")) {
                currentRoom = attic;
            }
            if (nextRoom.equals("basement")) {
                currentRoom = basement;
            }

            if (nextRoom == "") {
                System.out.println("There is no door!");
            } else {
                search = false;
                printCurrentRoomDescription();
            }

        } else {
            System.out.println("You are in the dark, you need to look for the exits to find them!"
                    + "dev tip: maybe you can use the command 'seek' ");
        }
    }

    private void drink() {
        System.out.println("You feel very thirsty...");
        System.out.print("Type yes to drink the soda, or no if you are fitness and will wait for some water:\n>");

        String drink = input.next();

        if (drink.equals("yes")) {
            System.out.println("Oooh, you are falling asleep... I think it was pois...");
            System.out.println("YOU DIED!");
            System.exit(0);
        } else {
            if (drink.equals("no")) {
                System.out.println("Nice choice! You put it back in the table");
            } else {
                System.out.println("I didn't understand...");
                drink();
            }
        }
    }

    private void feedPet() {
        System.out.println("Maybe you could feed him with somw of your cookies");
        System.out.println("Type 'yes' or 'no'");
        String feed = input.next();

        if (feed.equals("yes")) {
            System.out.println("You fed it!");
        } else if (feed.equals("no")) {
            System.out.println("You're nasty");
        } else {
            System.out.println("I don't understand...");
            feedPet();
        }
    }

    private boolean pickKey() {
        System.out.println("Do you want to pick the key up?");
        System.out.println("Type 'yes' or 'no");

        String pick = input.next();
        if (pick.equals("yes")) {
            System.out.println("You've collected a key!");
            pub.removeItem(pub.getAllItems());
            gotKey = true;
        } else if (pick.equals("no")) {
            System.out.println("You put it back");
        } else {
            System.out.println("I don´t understand...");
            pickKey();
        }
        return gotKey;
    }

    private void openChest() {
        if(gotKey){
            System.out.println("You've already gotten a key.");
            System.out.println("Do you want to open the chest?");
            System.out.println("Type 'yes' or 'no'");
            
            String open = input.next();
            if(open.equals("yes")){
                System.out.println("You openned it!");
                System.out.println("A very bright light starts shining from inside while you open it slowly...");
                System.out.println("WOW! What a scary experience! You woke uo in your bed! That was just a dream...");
                System.exit(0);
            } else if(open.equals("no")){
                System.out.println("You didn't open it.");
            } else{
                System.out.println("I don't understand...");
                openChest();
            }
        } else{
            System.out.println("You don't have a key.");
        }
    }

    private void seek(Room currentRoom, boolean hasSecondCommand) {
        if (hasSecondCommand) {
            System.out.println("Seek what?! Don't know what you mean...");
        } else {
            search = true;
            System.out.println("You looked around. " + currentRoom.getHideInformation());
            printExits();

            if (currentRoom.equals(lab)) {
                drink();
                printExits();

            }
            if (currentRoom.equals(pub)) {
                if (!gotKey) {
                    pickKey();
                } else {
                    System.out.println("You already looked here!");
                }
                printExits();

            }
            if (currentRoom.equals(attic)) {
                feedPet();
                printExits();

            }
            if (currentRoom.equals(basement)) {
                openChest();
                printExits();

            }
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game. Return true, if this command quits the game, false
     * otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}
