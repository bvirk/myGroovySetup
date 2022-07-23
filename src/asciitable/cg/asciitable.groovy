package cg;
import static cg.Print.p;

def asciiTable() {
    lines = []
    def line = "";
    def spaces = "  "
    for (def i in ["0 ","4 ","8 ","c ","10","14","18","1c"])
        line += i + spaces + spaces
    lines << line
    int lineLen=32;
    for (int lineBeg = 32; lineBeg < 255; lineBeg +=lineLen) {
        line = Integer.toString(lineBeg,16)+"  "
        for ( char chr = lineBeg; chr < lineBeg+lineLen; chr++) {
            line += chr;
            if ((int)chr % 4 == 3)
                line += spaces
        }
        lines << line
    }
    lines
}
p asciiTable()
p "done"
