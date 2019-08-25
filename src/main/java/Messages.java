
public class Messages {
    public static final String WON = "WON!";
    public static final String GAME_OVER = "Game Over!";
    public static final String WELCOME = "Welcome to Master Mind Game!";
    public static final String INVALID_COLOURS = "Error: you have given invalid colour(s)!";
    public static final String INVALID_LENGTH = "Error: you must pass 4 colours!";
    public static final String EXCEED_MAX_ATTEMPT = "Error: you only have 60 attempts!";
    public static final String EMPTY_INPUT = "Error: input is empty!";
    public static final String GAME_RULES = "Master Mind will select 4 random colours from our " +
            "colour list: \nRED, BLUE, GREEN, ORANGE, PURPLE, YELLOW\n\n" +
            "Colours CAN be duplicated but there will always be exactly 4\n" +
            "Please choose and type in 4 colours in CAPITAL letters, separated by whitespace\n" +
            "e.g: RED BLUE GREEN YELLOW is acceptable\n\n" +
            "For every correctly positioned colour in the array, 'Black' will be returned, for " +
            "every correct colour but int the wrong position, 'White' will be returned\n" +
            "Good luck, you only have 60 attempts to guess the correct list of colours!\n\n" +
            "4 colours have been chosen";
}
