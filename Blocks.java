package block_chaine;

import java.util.*;


public class Blocks {
    private List<Block> blockchain= new ArrayList<>(100);
    List<String> data= new ArrayList<>(10);
    private int index=0; 
    miner mine=new miner();

    public void SetGenesisBlock() { 
        String prevHash="0000000000000000000000000000000000000000000000000000000000000000";
        data.add("This is a Genesis block");
        Block GenesisBlock = new Block(index,1,prevHash,data);
        boolean GoldenHash=mine.GoldenHash(GenesisBlock);
        while(!GoldenHash){
            GenesisBlock.IncrementNonce();
            GenesisBlock.setHash();
            GoldenHash=mine.GoldenHash(GenesisBlock);
        }
        blockchain.add(GenesisBlock);
        data.clear();
    }
    
    public Block Last(){
        return blockchain.get(blockchain.size()-1);
    }
    public Block GetBlock(int index){
        return blockchain.get(index);
    }

    public void AddBlock(int t){
        Scanner scan=new Scanner(System.in);
        String prevHash=Last().getHash();
        index++;
        for(int j=0;j<t;j++){
            System.out.print("State the transaction "+j+" you want to store in block "+index+"  ==> ");
            String newdata= scan.next();
            newdata += scan.nextLine(); 
            data.add(newdata);        }
        Block block = new Block(index,t,prevHash,data);

        boolean GoldenHash=mine.GoldenHash(block);
         while(!GoldenHash){
            block.IncrementNonce();
            block.setHash();
            GoldenHash=mine.GoldenHash(block);
        }
        blockchain.add(block);
        System.out.println("Successfully added to the blockchain !!");
        data.clear();
        
        
            

    }
    public int Size(){
        int s = blockchain.size();
        return s;
    }

    public void BlocksContext(){
        
        for(int i=0;i<blockchain.size();i++){
            blockchain.get(i).Context();
        }
        
    }

    public boolean Valid(){
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            
            if (!currentBlock.getHash().equals(currentBlock.getHash())) {
                return false;
            }
            
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public void Modify(int index,int j,String newData){
        blockchain.get(index).setData(j,newData);
        blockchain.get(index).setHash();

    }



   



}