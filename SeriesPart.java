import java.io.*;

public class SeriesPart {
    static long startTime = 0;

    private static void tick(){
        startTime = System.currentTimeMillis();
    }
    private static float tock(){
        return (System.currentTimeMillis() - startTime) / 1000.0f;
    }

    public static void main (String[] args) throws IOException {
        File f = new File("sample_input.txt");
        int n=0;
        String s;
        String sizeArray[];
        String valueArray[];
        String numberArray[];
        String treeSizeArray[];
        float TreeArray[] = new float[0];
        float[][] grid = new float[0][0];
        float total=0;
        int numberTrees=0;
        int Tree=0;
        int x=0;
        int y=0;
        int k=0;
        int Treex=0;
        int Treey=0;
        float count=0;
        int TreeSize=0;
        float sunlight=0;
        int count2=0;


        BufferedReader br = new BufferedReader(new FileReader(f));

        while((s=br.readLine()) != null){
            try {
                n++;
                if (n == 1) {
                    String line = s;
                    sizeArray = line.split(" ");
                    x = Integer.parseInt(sizeArray[0]);
                    y = Integer.parseInt(sizeArray[1]);
                    grid = new float[x][y];
                }

                if (n == 2) {
                    String line = s;
                    valueArray = line.split(" "); //0, 1, 2...
                    for (int i = 0; i < x; i++) {
                        for (int j = 0; j < y; j++) {
                            grid[i][j] = Float.parseFloat(valueArray[k]);
                            k++;
                        }

                    }

                }

                if (n==3){
                    String line = s;
                    numberArray = line.split(" ");
                    numberTrees = Integer.parseInt(numberArray[0]);
                    TreeArray = new float[numberTrees]; //for later information storage
                }

                if(n>3){
                    if(n==4){
                        tick();
                    }
                    sunlight=0;
                    Tree++; //number of the tree being looked at
                    String line =s;
                    treeSizeArray = line.split(" ");
                    Treex = Integer.parseInt(treeSizeArray[0]);
                    Treey = Integer.parseInt(treeSizeArray[1]);
                    TreeSize = Integer.parseInt(treeSizeArray[2]);

                    if ((Treex+TreeSize)>x && (Treey+TreeSize)>y){
                        for (int i = Treex; i < x; i++) { //if tree goes off the grid
                            for (int j = Treey; j < y; j++) {
                                sunlight += grid[i][j];
                            }
                        }
                    }

                    


                    else {
                        for (int i = Treex; i < Treex + TreeSize; i++) { //tree on the grid
                            for (int j = Treey; j < Treey + TreeSize; j++) {
                                sunlight += grid[i][j];
                                //total += grid[i][j];
                            }
                        }
                    }
                    TreeArray[Tree-1] = sunlight; // stores the trees sunlight by its number
                    total+=sunlight;
                }



            }catch(Exception e){

            }
        }
        float time = tock();
        System.out.println("Sequenial");
        System.out.println(time);
        PrintWriter w = new PrintWriter("output.txt", "UTF-8");
        float average = total/numberTrees;
        w.println(average);
        w.println(numberTrees);
        for (int i=0; i<TreeArray.length;i++){
            w.println(TreeArray[i]);

        }
        w.close();
    }

}
