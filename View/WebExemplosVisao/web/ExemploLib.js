function fatorial(x) {
   if (x<2)
      return 1;
   else
      return x * fatorial(x-1);
}

function ePrimo(x) {
   for (a=2; a<x; a++) {
      if ((x%a) === 0) return false;
   }
   return true;
}