function signup() {
    var id = document.getElementById("id").value;
    var userName = document.getElementById("userName").value;
    var password = document.getElementById("password").value;
    var passwordConfirmation = document.getElementById("passwordConfirmation").value;

    // 유효성 검사
    if (!id || !userName || !password || !passwordConfirmation) {
        alert("모든 필수 항목을 입력해주세요.");
        return;
    }
    if (password !== passwordConfirmation) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        return;
    }

    // 서버로 데이터 전송
    var userData = {
        id: id,
        user_name: userName,
        password: password
    };

    fetch('/api/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            }
            throw new Error('회원가입에 실패했습니다.');
        })
        .then(data => {
            alert(data);
            // 회원가입 성공 시 다음 작업을 수행하거나 페이지를 리디렉션할 수 있습니다.
        })
        .catch(error => {
            console.error('Error:', error);
            alert('회원가입에 실패했습니다.');
        });
}
