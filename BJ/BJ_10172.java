
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BJ_10172 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출력해야하는 문자열을 bw에 넣기
        bw.write("|\\_/|\n");
        bw.write("|q p|   /}\n");
        bw.write("( 0 )\"\"\"\\\n");
        bw.write("|\"^\"`    |\n");
        bw.write("||_/=\\\\__|\n");
        // bw에 담긴 데이터들을 한 번에 출력
        bw.flush();
        bw.close();
    }
}
