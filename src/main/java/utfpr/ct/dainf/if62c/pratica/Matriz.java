package utfpr.ct.dainf.if62c.pratica;

/**
 * Representa uma matriz de valores {@code double}.
 * @author Fernando
 */
public class Matriz {
    
    private final double[][] mat; // a matriz representada por esta classe
    
  
    public Matriz(int m, int n) { // construtor que aloca a matriz
        mat = new double[m][n];
    }
    
    public double[][] getMatriz() { // retorna a matriz
        return mat;
    }
    
    public Matriz getTransposta() { // retorna a matriz transposta
        Matriz t = new Matriz(mat[0].length, mat.length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                t.mat[j][i] = mat[i][j];
            }
        }
        return t;
    }
    
    public Matriz soma(Matriz m) {  // retorna a soma desta matriz com a matriz recebida como argumento
        Matriz retornada;

        retornada = new Matriz(mat.length,mat[0].length);
        
        for(int i=0;i < mat.length ;i++)
        {
            for(int j=0;j < mat[0].length ;j++)
            {
                retornada.mat[i][j] = m.mat[i][j] + mat[i][j];
            }
        }
        return retornada;
    }
    
    public Matriz prod(Matriz m) { // retorna o produto desta matriz com a matriz recebida como argumento
        int i, j, k;
       
       Matriz Produto = new Matriz(mat.length, m.mat[0].length);
       
        for (i=0; i < mat.length; i++)
            for (j = 0; j < m.mat[0].length; j++)
                for(k = 0 ; k < mat[0].length ; k++) {
                    Produto.mat[i][j] += mat[i][k] * m.mat[k][j];
                }
       
        return Produto;
    }

    @Override
    public String toString() { // retorna uma representação textual da matriz
        StringBuilder s = new StringBuilder();
        for (double[] linha: mat) {
            s.append("[ ");
            for (double x: linha) {
                s.append(x).append(" ");
            }
            s.append("]");
        }
        return s.toString();
    }
}