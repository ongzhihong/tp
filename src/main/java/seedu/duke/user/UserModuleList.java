package seedu.duke.user;

import java.util.ArrayList;

import seedu.duke.module.Module;

/**
 * Class of module list that manages the modules that the user is interested in.
 * This is based on NUS Modules that user wishes to map overseas in the future
 */

public class UserModuleList {
    private ArrayList<Module> modules;

    public UserModuleList() {
        this.modules = new ArrayList<>();
    }

    public ArrayList getModules() {
        return modules;
    }

    /**
     * Method to find current modules user stored by code.
     * @param input input code of module
     * @return true if module is found, false otherwise
     */
    public boolean findModuleByCode(String input) {
        for (Module module : modules) {
            if (module.getCode().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public void addModule(Module input) {
        if (findModuleByCode(input.getCode())) {
            System.out.println("Error module already added");
        } else {
            modules.add(input);
        }
    }

    public void displayAll() {
        if (modules.size() == 0) {
            System.out.println("No current modules saved");
        } else {
            for (int i = 0; i < modules.size(); i++) {
                System.out.print(i + 1);
                System.out.print(" : ");
                System.out.println(modules.get(i).toString());
            }
        }
    }

    public void deleteModule(int index) {
        index--;
        try {
            System.out.println("Deleting module:");
            System.out.println(modules.get(index).toString());
            modules.remove(index);
            System.out.println("Modules left are: ");
            displayAll();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index not within range");
        }
    }

    /**
     * Method to find current modules user stored by keyword
     * @param keyword input keyword
     * @return true if any module containing keyword is found, false otherwise
     */
    public boolean findModuleByTitle(String keyword) {
        int counter = 0;
        for (Module module : modules) {
            if (module.getTitle().contains(keyword)) {
                counter++;
                System.out.println(module);
            }
        }
        if (counter == 0) {
            System.out.println("No modules with such keyword found");
            return false;
        }
        return true;
    }
}
