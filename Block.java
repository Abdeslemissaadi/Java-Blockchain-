package block_chaine;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Block{
    private List<String> data= new ArrayList<>(10);
    private int index;
    private int transacionsNum;
    private long timestamp;
    private String previousHash;
    private String Hash;
    private int nonce;

    public Block(int index,int t,String previousHash,List<String> d){
        this.index=index;
        this.transacionsNum=t;
        this.previousHash=previousHash;
        this.timestamp=System.currentTimeMillis();
        for(int j=0;j<t;j++){
            this.data.add(d.get(j));
        }
        this.Hash=calculateHashAll();
        this.nonce=0;
    }

    public String getHash(){
        return Hash;
    }

    
    public int getTransactionsNum(){
        return transacionsNum;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public int IncrementNonce(){
        this.nonce ++;
        return nonce;
    }

    public void setData(int j,String newData){
        this.data.set(j, newData);
    }

    public void addData(String newData){
        this.data.add(newData);
    }
    
    public void setHash(){
        this.Hash=calculateHashAll();
    }
    public String mercleRoot(){
        String[] mercleTable=new String[transacionsNum];
        for(int i=0;i<mercleTable.length;i++){
            mercleTable[i]=calculateHashData(data.get(i));
        }
        
        int len=mercleTable.length;
       while(len > 1){
            String[] Tempo;
            if(len % 2  ==1){
                Tempo=new String[(len/2)+1];
                int Tlen=Tempo.length;
                Tempo[Tlen-1]=mercleTable[len -1];
            }else{
                Tempo=new String[(len/2)];
            }
            for(int i=0;i<len/2;i++){
                String subHash=mercleTable[i*2].concat(mercleTable[i*2 +1]);
                Tempo[i]=calculateHashData(subHash);
            }
            mercleTable=Tempo;
            len=mercleTable.length;        
        }


        return mercleTable[0];
    }

    public String calculateHashData(String data){
        String text=String.valueOf(data);
        MessageDigest digest= null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        final byte bytes[]=digest.digest(text.getBytes());
        final StringBuilder hexString = new StringBuilder();
        for(final byte b:bytes){
            String hex=Integer.toHexString(0xff &b);
            if(hex.length()==1){
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public String calculateHashAll(){
        String text=String.valueOf(nonce+index+previousHash+String.valueOf(mercleRoot())+String.valueOf(timestamp));
        MessageDigest digest= null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        final byte bytes[]=digest.digest(text.getBytes());
        final StringBuilder hexString = new StringBuilder();
        for(final byte b:bytes){
            String hex=Integer.toHexString(0xff &b);
            if(hex.length()==1){
                hexString.append("0");
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public void Context(){
        System.out.println("-------------------------------------------------");
        System.out.println("le nombre de block : "+index);
        System.out.println("numéro de transaction : "+transacionsNum);
        System.out.println("Nonce :"+nonce);
        System.out.println("Data :");
        for(int i=0;i<transacionsNum;i++){
            System.out.println("      numéro de transaction "+i+" ==> "+data.get(i));
        }
        System.out.println("Mercle root : "+mercleRoot());
        System.out.println("Previous Hash : "+previousHash);
        System.out.println("Block Hash : "+String.valueOf(Hash));
        System.out.println(" TimeStamp de Block : "+timestamp);
        System.out.println("-------------------------------------------------");
    }
}