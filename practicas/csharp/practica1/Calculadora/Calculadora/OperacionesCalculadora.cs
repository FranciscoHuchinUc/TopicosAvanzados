using System;

namespace Calculadora
{
    public class OperacionesCalculadora
    {

        public string opResultado(string operador, int pNum, int sNum)
        {
            switch (operador)
            {
                case "+":
                    int suma = pNum + sNum;
                    return suma + "";
                
                case "-":
                    int resta = pNum - sNum;
                    return resta + "";
                
                case "/":
                    if (pNum > 0 && sNum > 0)
                    {
                        int divicion = pNum / sNum;
                        return divicion + "";
                    }
                    else
                    {
                        return "No se Puede dividir entre cero";
                    }
                
                case "*":
                    int multiplicacion = pNum * sNum;
                    return multiplicacion + "";
                
                case "^":
                    if (sNum != 0)
                    {
                        double elevar = Math.Pow(pNum, sNum);
                        return elevar + "";
                    }
                    break;
                
            }

            return null;
        }

    }
}