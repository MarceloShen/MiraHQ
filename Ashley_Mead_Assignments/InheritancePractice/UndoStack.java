package InheritancePractice;

import java.util.ArrayList;

// This class can access the super class and other objects in practice-it
public class UndoStack extends StringStack {
    
    // Previous commands that can be undone
    ArrayList<String> undoCommands;
    
    public UndoStack() {
        super();
        this.undoCommands = new ArrayList<String>();
    }
    
    public void undo() {
        if(!canUndo()) {
            throw new IllegalStateException();
        }
        
        String latestUndoCommand = undoCommands.get(undoCommands.size() - 1);
        // Perform the most recent command
        if(latestUndoCommand == "pop") {
            super.pop();
        }
        else {
            super.push(latestUndoCommand);
        }
        // The command has been completed
        this.undoCommands.remove(this.undoCommands.size() - 1);
    }
    
    public boolean canUndo() {
        return this.undoCommands.size() >= 1;
    }
    
    public void push(String s) {
        super.push(s);
        // The opposite command to push is pop, so the undo command for push would be pop
        this.undoCommands.add("pop");
    }
    
    public String pop() {
        // Keep track of the String being popped so we can push it back to undo if necessary
        String undoCommand = super.pop();
        this.undoCommands.add(undoCommand);
        return undoCommand;
    }
    
}