
package block_chaine;



public class miner {
    private int difficulty=3;
     
    public boolean GoldenHash(Block block){
        String leadingZeros = new String(new char[difficulty]).replace('\0', '0');
        
        boolean valid =block.getHash().substring(0,difficulty).equals(leadingZeros);
        
        return valid;
    }

}





