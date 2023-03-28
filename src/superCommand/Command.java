package superCommand;

import exception.IncorrectInputInScriptException;

import java.io.IOException;

/**
 * Interface use method execute
 */
interface Command {

    /**
     * Method for executing command
     */
    default void execute() throws IncorrectInputInScriptException {
        System.out.println("Command is executing");
    }

    /**
     * Method for executing command with args
     */
    default void execute(String args) throws IOException, IncorrectInputInScriptException {
        System.out.println("Command is executing");
    }

    /**
     * Method for executing command with args
     */
    default void execute(Long args){
        System.out.println("Command is executing");
    }

    default <T> void execute(T arg){
        System.out.println("ll");
    }

}