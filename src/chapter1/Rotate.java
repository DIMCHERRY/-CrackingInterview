package chapter1;

/*
 * 给定一幅由N*N矩阵表示的图像，其中每个像素的大小为4字节。
 * 编写一个方法，将图像旋转90度，不占用额外内存空间能否做到？
 */

/*
 * 按索引一个一个进行交换，具体做法如下：
 * for i=0 to n
 *     temp=top[i];
 *     top[i]=left[i];
 *     left[i]=bottom[i]
 *     bottom[i]=right[i]
 *     right[i]=temp
 * 解法：在每一层上执行上述交换。（也可从内层开始，逐层向外。）
 */

/*
 * 该算法的时间复杂度为O(N^2)，这已是最优的做法，因为任何算法都需要访问所有N^2个元素。
 */
public class Rotate {
	public static void rotate(int[][] matrix,int n){
		for(int layer=0;layer<n/2;++layer){
			int first=layer;
			int last=n-1-layer;
			//offset意为偏移，matrix意为矩阵
			for(int i=first;i<last;++i){
				int offset=i-first;
				//存储上边
				int top=matrix[first][i];
				//左到上
				matrix[first][i]=matrix[last-offset][first];
				//下到左
				matrix[last-offset][first]=matrix[last][last-offset];
				//右到下
				matrix[last][last-offset]=matrix[i][last];
				//上到右
				matrix[i][last]=top;
			}
		}
	}

	public static void main(String[] args){
		int[][] matrix={{1,1,1,1},{2,2,2,2},{3,3,3,3},{4,4,4,4}};
				rotate(matrix,4);
				for(int i=0;i<matrix.length;i++){  //打印矩阵		              
		            for(int j=0;j<matrix[i].length;j++){  		                      
		                System.out.print(matrix[i][j]+" ");  		                  
		            }  
		            System.out.println();
		}
	}
}
