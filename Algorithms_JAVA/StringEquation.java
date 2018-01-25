package fb.glassdoor;

public class StringEquation {
	
    public double solve(String equation) {
        int indexEqualSign = equation.indexOf('=');
        int[] left = simplify(equation.substring(0, indexEqualSign));
        int[] right = simplify(equation.substring(indexEqualSign + 1));
        return 1.0 * (left[0] - right[0]) / (right[1] - left[1]);
    }

    private int[] simplify(String exp) {
        int i = 0;
        int num = 0, sign = 1;
        int sum = 0, factor = 0;
        while(i < exp.length()) {
            char c = exp.charAt(i);
            if(c == ' ') {
            } else if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                if (c == 'x') {
                    factor += sign * (num == 0 ? 1: num);
                } else {
                    sum += num * sign;
                    sign = c == '+' ? 1 : -1;
                }
                num = 0;
            }
            i++;
        }
        sum += sign * num;
        return new int[]{sum, factor};
    }
    
    public static void main(String[] args) {
		StringEquation test = new StringEquation();
		String s = "x + 2 = 6";
		
		System.out.println(test.solve(s));
	}

}
