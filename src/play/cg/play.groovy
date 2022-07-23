package cg;
import static cg.Print.p;
import cg.MachineSettings;
import static cg.Dirutils.basename;
import static cg.Jimport.jimport;
import static cg.Jimport.japiUrl;

import cg.ConsoleInput;


public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY 
}
p Day.values()

def movieList = ['Dersu Uzala', 'Ran', 'Seven Samurai']
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
def monthMap = [ 'January' : 31, 'February' : colors, 'March' : movieList ]
p monthMap
p MachineSettings.jarList
p basename("this/little/file",true)
