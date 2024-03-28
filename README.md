# 2024-03-28

> Websocket 연결
>> postman에서 연결 확인 완료
>>> 참고 url : https://senslife.tistory.com/52  
>>> html 연결 코드  
```<!DOCTYPE html>
<html>
<head>
    <title>WebSocket Example</title>
    <script>
        // 웹소켓 연결
        const socket = new WebSocket('ws://localhost:8080/websocket');

        // 연결이 열리면 메시지 전송
        socket.addEventListener('open', (event) => {
            socket.send('Hello WebSocket!');
        });

        // 메시지 수신 처리
        socket.addEventListener('message', (event) => {
            console.log('Message from server: ', event.data);
        });
    </script>
</head>
<body>
</body>
</html>
```
