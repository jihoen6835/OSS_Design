document.getElementById('signup-form').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from being submitted

    var password = document.getElementById('password').value;
    var passwordCheck = document.getElementById('passwordCheck').value;

    if (password !== passwordCheck) {
        alert('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
        return;
    }

    var formData = {
        userName: document.getElementById('userName').value,
        loginId: document.getElementById('loginId').value,
        password: password,
        passwordCheck: passwordCheck,
        role: document.querySelector('input[name="role"]:checked').value
    };

    fetch('/api/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
        .then(response => response.json())
        .then(data => {
            alert('회원가입이 완료되었습니다! ');
            window.location.href = '/'; // Redirect to the main page
        })
        .catch(error => {
            console.error('Error:', error);
            alert('회원가입 실패');
        });
});