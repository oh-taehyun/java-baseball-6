package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
/* 
 * 컴퓨터가 입력한 랜덤 숫자를 변수로 randomNumber로 받고 배열에 저장한다.
내가 입력한 숫자를 받고 배열에 저장한다
게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
컴퓨터가 입력한 숫자와 내가 입력한 숫자를 두 배열에서 각각 꺼내 비교한다.
비교했을 때 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 출력한다.
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.*/

public class Application {
    public static void main(String[] args)throws IllegalArgumentException {
    	
    	List<Integer> computer = new ArrayList<>(); 
    	System.out.println("숫자 야구 게임을 시작합니다.");
   while(true) {
	   while (computer.size() < 3) {
   	    int randomNumber = Randoms.pickNumberInRange(1, 9);
   	    if (!computer.contains(randomNumber)) {
   	        computer.add(randomNumber);
   	    }
   	}
   	System.out.println(computer.toString());
   	


   	while(true) {
   	    int strike =0;
   	    int ball = 0;
   	    System.out.print("숫자를 입력해주세요 : ");
   	    String userInput=Console.readLine();
   	    if(userInput.contains("0")||userInput.length()!=3)
   	    	throw new IllegalArgumentException();
       	int userNumber = Integer.parseInt(userInput);
       	List<Integer> userArr = new ArrayList<>();
       	userArr.add(userNumber/100);
       	userArr.add((userNumber%100)/10);
       	userArr.add(userNumber%10);
   	    for(int i=0;i<computer.size();i++) {
   	    	for(int j=0;j<userArr.size();j++) {
   	    		if(i==j) {
   	    			if(computer.get(i).equals(userArr.get(j)))
   	    				strike++;
   	    		}else {
   	    			if(computer.get(i).equals(userArr.get(j)))
   	    				ball++;
   	    		}
   	    	}
   	    }
   	    if(strike !=0 && ball !=0) {
   	    	System.out.println(ball +"볼 "+ strike+"스트라이크");
   	    }
   	    if(strike==0 && ball !=0) {
   	    	System.out.println(ball+"볼");
   	    }
   	    if(strike !=0 && ball==0) {
   	    	System.out.println(strike+"스트라이크");
   	    }
   	    if(strike==0 && ball==0) {
   	    	System.out.println("낫싱");
   	    }
   	   if(strike==3) {
   		   System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
   		  computer.clear();
   		  break;
   	   }
   	}
	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	String playInput = Console.readLine();
	int play= Integer.parseInt(playInput);
	if(!(play==1||play==2)) {
		throw new IllegalArgumentException();
	}
	if(play==2) {
		break;
	}
   }
    	
    }
}
