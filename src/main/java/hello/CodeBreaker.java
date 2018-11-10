package hello;

public class CodeBreaker {

    private String secret="";

    public CodeBreaker () {
        int random;
        for (int i = 0; i<4; i++) {
            random = (int) (Math.random() * 10);
            secret=secret.concat(String.valueOf(random));
        }
        System.out.println(secret);
    }
    public String getSecret() {
        return this.secret;
    }
    public CodeBreaker (String secret) {
        this.secret = secret;
    }

    public void setSecret(String secret){
        this.secret=secret;
    }


    public String guesst(String number) {
        String answer = "";
        if (number != null) {
            for(int i =0; i < secret.length(); i++) {
                if(number.charAt(i) == secret.charAt(i)) {
                    answer = answer.concat("X");
                }else if(number.indexOf(secret.charAt(i))!= -1) {
                    answer = answer.concat("_");
                }
            }
        }

        return answer;
    }

}