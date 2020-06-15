class Kpalindrome
{
  static int lcs(String X, String Y, int m, int n)  
  {
        int L[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)  
            {
                if (i == 0 || j == 0)  
                {
                    L[i][j] = 0;
                }  
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                {
                    L[i][j] = L[i - 1][j - 1] + 1;
                }  
                else
                {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[m][n];
    }
    static boolean isKPal(String str, int k)  
    {
        int n = str.length();
        StringBuilder revStr = new StringBuilder(str);
        revStr = revStr.reverse();
        int lps = lcs(str, revStr.toString(), n, n);
        return (n - lps <= k);
    }
public static void main(String[] args)  
{
        String str = "abcdeca";
        int k = 2;
        if (isKPal(str, k))
        {
            System.out.println("Yes");
        }
        else
            System.out.println("No");
    }
} 
