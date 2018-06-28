package chapter1;

/*
 * 编写一个算法若M*N矩阵中某个元素为0，则将其所在行与列清零。
 */
public class SetZeros {
	public static void setZeros(int[][] matrix){
		boolean[] row=new boolean[matrix.length];
		boolean[] column=new boolean[matrix[0].length];
		
		//记录值为0的元素所在的行索引与列索引
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					row[i]=true;
					column[j]=true;
				}
			}
	}
    //若行i或列j有个元素为0，则将arr[i][j]置为0
	for(int i=0;i<matrix.length;i++){
		for(int j=0;j<matrix[0].length;j++){
			if(row[i]||column[j]){
				matrix[i][j]=0;
			}
		}
	 }
	}

    public static void main(String[] args){
    	int[][] matrix={{1,0,1,1},{2,2,2,2},{3,3,3,3}};
    	setZeros(matrix);
    	for(int i=0;i<matrix.length;i++){  //打印矩阵		              
            for(int j=0;j<matrix[i].length;j++){  		                      
                System.out.print(matrix[i][j]+" ");  		                  
            }  
            System.out.println();
    }
}
}