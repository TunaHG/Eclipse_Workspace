package Network;

/*
 * Network : 유선, 무선을 이용해서 데이터 통신을 하기 위해
 * 			  컴퓨터를 논리적, 물리적으로 묶어놓은 형태
 * 
 * Network의 형태 (크기에 따라서 여러가지 형태로 구분
 * 1. LAN(Local Area Network)
 * 2. WAN(Wide Area Network)
 * 3. MAN(Metropolitan Area Network)
 * 
 * Internet : Network of Network
 * 			   물리적인 네트워크의 형태
 * Internet을 사용하기 위해 그 위에서 동작하는 Service가 필요
 * => Web Service, Email Service, Torrent, Streaming
 * 
 * Internet 위에서 각각의 Service가 동작하기위해
 * 각 컴퓨터들이 서로를 인지할 수 있는 수단이 필요
 * => 각 컴퓨터의 NIC(Network Interface Card, LAN Card)마다 주소(IP)를 부여
 * 
 * IP
 * IPv4 => xxx.xxx.xxx.xxx (32비트)
 * 초기에는 IPv4로 문제없이 사용했고, 현재도 사용 중
 * 하지만 점점 주소가 모자라게되며 IPv6로 해결방법을 찾고있음
 * 
 * IP Address
 * NIC, LAN Card에 부여된 논리적인 주소 (논리적 : 다른값으로 변경될 수 있다는 의미)
 * 하지만, 논리적인 주소만으로는 컴퓨터간의 통신이 불가능, 물리적인 주소가 필요
 * 물리적인 주소를 MAC Address라고 함
 * ==> IP Address를 이용해서 특정 컴퓨터를 탐색
 * ==> IP Address는 숫자라서 기억하기가 쉽지 않음
 * 	   => DNS(Domain Name System)를 도입 (www.naver.com)
 * 
 * Protocol
 * 통신을 하기위해 필요
 * TCP, IP, ARP, TELNET, FTP, ... HTTP
 * 
 * Port
 * 0 ~ 65535의 범위를 가지는 숫자, 0 ~ 1023번까지는 예약되어있음
 * 컴퓨터 내에 동작하고 있는 프로그램을 지칭하는 숫자
 * 
 * 결론적으로 한 컴퓨터와 다른 컴퓨터가 데이터를 주고 받으려면
 * 1. Protocol
 * 2. IP Address
 * 3. Port Number
 * 세 가지를 알아야 함
 * 
 * Socket
 * 복잡한 네트워크 처리를 대신 처리하는 도구
 * 
 * Java Network Program은 CS(Client-Server)구조를 가진다.
 */
public class Exam00_JavaNetwork {

}
