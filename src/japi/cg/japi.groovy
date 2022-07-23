package cg;

import static cg.Print.p;
import static cg.MachineSettings.*;
import static cg.Jimport.jimport;
import static cg.Jimport.japiUrl;
import static cg.ConsoleInput.strOfInput;


/**
* browse api documentation for class. Argument is command line argument.
*/
def jdoc() {
    if (args.length == 0) 
        p "usage: cks class"
    else  {
        def classes = jimport(args[0]);
        if (classes.size() > 0) {
            String chosenClass;
            if (classes.size() > 1) {
                chosenClass = strOfInput(classes);
                if (null == chosenClass)
                    System.exit(0)
            } else
                chosenClass=classes.get(0)
            String[] packPath = chosenClass.split(":");
            def url = japiUrl(packPath[0])+packPath[1].trim().replaceAll(/\.class\s*$/,'.html')
            Runtime.getRuntime().exec(new String[]{browser,url}); 
        } else
            p "no Class "+args[0]
    }
}
jdoc()


