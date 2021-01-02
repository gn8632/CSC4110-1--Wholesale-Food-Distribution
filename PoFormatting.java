package sample;
import java.io.PrintWriter;
import java.util.List;

public class PoFormatting {

    /** ---------------------------------------------------------------------------**/

    public void printFooter(PrintWriter pw, StringBuffer designDetail, double subTotal,
                            double totalShipping){

        String ownerName = "WSU Inc";
        String ownerAdd = "1 Woodward Ave, Detroit, MI, 48322";
        String ownerPhone = "313-333-3333";
        String ownerMail = "GrandmasCookies@email.uk";

        pw.write("\n");
        pw.write(String.valueOf(designDetail));

        pw.write("\n");
        pw.write(String.valueOf(designDetail));

        String sTot = "Sub Total: ";
        String ship = "Shipping Cost: ";
        String tax = "Total Tax: ";
        String gTot = "Grand Total: ";

        /** we take subTotal and totalShipping data passed through method and
         * do basic math to calculate taxes and grand total
         */
        double taxFigure = subTotal * 0.06;
        double grandTotalFigure = subTotal + taxFigure + totalShipping;

        pw.write("\n");
        pw.write(String.format("%-58.38s", ownerName));
        pw.write(String.format("%14.38s", sTot + subTotal));

        pw.write("\n");
        pw.write(String.format("%-58.38s", ownerAdd));
        pw.write(String.format("%14.38s", ship + totalShipping));

        pw.write("\n");
        pw.write(String.format("%-58.38s", ownerPhone));
        pw.write(String.format("%14.38s", tax + taxFigure));

        pw.write("\n");
        pw.write(String.format("%-58.38s", ownerMail));
        pw.write(String.format("%14.38s", gTot + grandTotalFigure));

        pw.write("\n");
        pw.write(String.valueOf(designDetail));
    }

    /** ---------------------------------------------------------------------------**/

    /** this is little tricky, it takes the list of the items as a parameter, then
     * based on how big list is, prints out necessary number of lines and formatting details **/
    public void printLineNumbers(PrintWriter pw, List<Item> list){
        for (Item item: list){
            pw.write("\n");
            pw.write(String.format("|%-8.8s",item.getiD()));
            pw.write(String.format("|%-13.8s|",item.getIType()));
            pw.write(String.format("%-14.13s|",item.getQuantity()));
            pw.write(String.format("$ %-26.7s|",item.getIPrice()));
            pw.write(String.format("%10.2f",item.getNetAmt()));
        }

        for (int i = 0; i < 10; i++){
            pw.write("\n");
            pw.write(String.format("|%-8.8s|", ""));
            pw.write(String.format("%-13.13s|", ""));
            pw.write(String.format("%-14.7s", ""));
            pw.write(String.format("|%-28.7s|", ""));
            pw.write(String.format("%11.2s|", ""));
        }
    }

    /** Same as print purchase order method, hard coded since they are not something
     * that user must edit **/
    public void printLineHeaders(PrintWriter pw, StringBuffer designDetail){

        pw.write("\n");
        pw.write(String.valueOf(designDetail));
        pw.write("\n");

        pw.write(String.format("%-10.8s", "Item Id"));
        pw.write(String.format("%-14.9s", "Item Type"));
        pw.write(String.format("%-15.9s", "Quantity"));
        pw.write(String.format("%-31.7s", "Price"));
        pw.write(String.format("%-3.7s", "Total"));
        pw.write(" \t|");

        pw.write("\n");
        pw.write(String.valueOf(designDetail));
    }


}
