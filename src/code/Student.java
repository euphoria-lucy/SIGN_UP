package code;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Student extends InheritanceFrame {
	
	public static boolean loginIn = false; // 로그인 여부를 저장하는 변수
	
	private JButton joinbtn = new JButton();
	private JButton loginbtn = new JButton();
	private JButton enrolmentbtn = new JButton();
	private JButton listbtn = new JButton();
	
	public Student() {
		super("STUDENT", Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		
		JButtonStyle(joinbtn, 415, 400, 450, 65, "Student_Screen_Join_Button.png");
		JButtonStyle(loginbtn, 415, 500, 450, 65, "Student_Screen_Login_Button.png");
		JButtonStyle(enrolmentbtn, 1000, 35, 100, 100, "Student_Screen_Timetable_Button.png");
		JButtonStyle(listbtn, 1130, 35, 100, 100, "Student_Screen_Timetable_List_Button.png");
		
		JLabel lb = new JLabel(new ImageIcon(getClass().getResource("/image/Student_Screen.png")));
        lb.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        add(lb);
        
        joinbtn.addActionListener(e -> {
        	dispose();
        	new Student_Join().setVisible(true);
        });
        
        loginbtn.addActionListener(e -> {
            Student.loginIn = true; // 로그인이 완료되면 loginIn 변수를 true로 설정
            System.out.println("로그인 버튼 실행");

            dispose();
            new Student_Login().setVisible(true);
        });

        
        enrolmentbtn.addActionListener(e -> {
            if (Student.loginIn) {
                // 로그인된 상태이므로 수강신청 페이지 실행
                dispose();
                new Enrolment().setVisible(true);
                System.out.println("수강신청 창 열림");
            } else {
                // 로그인되지 않은 상태이므로 메시지를 표시
                JOptionPane.showMessageDialog(this, "로그인을 먼저 해주세요.", "안내", JOptionPane.WARNING_MESSAGE);
                System.out.println("수강신청 창 안열림");
            }
        });


        listbtn.addActionListener(e -> {
            if (loginIn) {
                dispose();
                try {
					new Timetable_Catalog().setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                System.out.println("시간표 목록 창 열림");
            } else {
                // 로그인되지 않은 상태이므로 메시지를 표시
                JOptionPane.showMessageDialog(this, "로그인을 먼저 해주세요.", "안내", JOptionPane.WARNING_MESSAGE);
                System.out.println("시간표 목록 창 안열림");
            }
        });
        
	}

	// 버튼 설정 메소드
    private void JButtonStyle(JButton button, int x, int y, int w, int h, String imageName) {
        button.setIcon(new ImageIcon(getClass().getResource("/image/" + imageName))); // 버튼 이미지 아이콘 설정
        button.setBorderPainted(false); // 버튼 테두리 제거 
        button.setContentAreaFilled(false); // 버튼 내부 영역 투명하게 설정 → 배경색상표시X
        button.setFocusPainted(false); // 포커스 받을 때 테두리 표시되지 않도록 설정
        button.setBounds(x, y, w, h); // 버튼 위치 나타내는 x, y좌표와 버튼 크기 설정인 가로 w, 세로 h
        add(button); // 프레임 추가
    }
	
}