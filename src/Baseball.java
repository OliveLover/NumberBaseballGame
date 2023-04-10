//컴퓨터는 0과 9 사이의 서로 다른 숫자 3개를 무작위로 뽑습니다. (ex) 123, 759
//사용자는 컴퓨터가 뽑은 숫자를 맞추기 위해 시도합니다.
//컴퓨터는 사용자가 입력한 세자리 숫자에 대해서, 아래의 규칙대로 스트라이크(S)와 볼(B)를 알려줍니다.
//숫자의 값과 위치가 모두 일치하면 S
//숫자의 값은 일치하지만 위치가 틀렸으면 B
//기회는 무제한이며, 몇번의 시도 후에 맞췄는지 기록됩니다.
//숫자 3개를 모두 맞춘 경우, 게임을 종료합니다.

import java.util.Random;
import java.util.Scanner;

public class Baseball {
    public static void main(String[] args) {
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        int quizNum;
        String quizString;

        //같은 숫자가 있는지 확인
        while(true){
            quizNum = random.nextInt(1000);
            int a = quizNum % 10;

            if(10< quizNum && quizNum <100){
                int b = quizNum / 10;
                if(a != b && a != 0)
                    break;
            }
            else if(quizNum > 100){
                int b = (quizNum / 10) %10;
                int c = quizNum / 100;
                if(a != b && a != c && b != c)
                    break;
            }
        }


        //랜덤숫자처리
        if(quizNum < 100)
            quizString = "0"+quizNum;
        else
            quizString = String.valueOf(quizNum);

        //System.out.println(quizString);
        String n = "";
        int S;
        int B;
        int count = 0;
        while (!n.equals(quizString)){
            S = 0;
            B = 0;
            System.out.print(++count +"번째 시도 : ");
            n = in.next();
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if(quizString.charAt(j) == n.charAt(i)) {
                        if (i == j) S++;
                        else B++;
                    }
                }
            }

            if (S == 0 && B==0)
                System.out.println(B+"B"+S+"S");
            else if (S == 0)
                System.out.println(B+"B");
            else if (B == 0)
                System.out.println(S+"S");
            else
                System.out.println(B+"B"+S+"S");
        }
        System.out.println(count+"번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }
}