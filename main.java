

package block_chaine;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Blocks chain1= new Blocks();
        chain1.SetGenesisBlock();
        Scanner scan = new Scanner(System.in);
        System.out.print("Combien de block vous voulez ajouter ? ==> ");
        int n = scan.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("State the number of transactions(data) you want to store in block "+i+"  ==> ");
            int t=scan.nextInt();
            chain1.AddBlock(t);
           

        }
        
        chain1.BlocksContext();
        System.out.println("ce blockchain est valide ? ==> "+chain1.Valid());
        System.out.println(" ");

        //System.out.print("Do you want to modify some block ? [Y/N] ==> ");
        String answer = scan.next();
        if (answer.equals("Y") || answer.equals("y")) {
            System.out.print("State the index of the block you want to change ==> ");
            int index=scan.nextInt();
            System.out.print("State the index of the data you want to change ==> ");
            int t=scan.nextInt();
            System.out.print("Write the new data ==> ");
            String newData=scan.next();
            newData +=scan.nextLine();
            chain1.Modify(index,t,newData);
            chain1.BlocksContext();

            System.out.println("Is this blockchain still valid ? ==> "+chain1.Valid());

        }

    }
}
