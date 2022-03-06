class Solution{
      public int countOrders(int n) {
	  var orders = 1L;
	   for (long places = 2L * n, MOD = (long) 1e9 + 7; places > 0; places -= 2)
		orders = orders * (places * (places - 1) >> 1) % MOD;
	  return (int) orders;
     }
}
