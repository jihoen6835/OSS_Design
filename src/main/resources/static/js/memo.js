document.addEventListener('DOMContentLoaded', function () {
    const memoForm = document.getElementById('memo-form');
    const memoTitle = document.getElementById('memo-title');
    const memoContent = document.getElementById('memo-content');
    const memoItems = document.getElementById('memo-items');

    memoForm.addEventListener('submit', function (e) {
        e.preventDefault();

        const title = memoTitle.value.trim();
        const content = memoContent.value.trim();

        if (title === '' || content === '') {
            alert('제목과 내용을 입력해주세요.');
            return;
        }

        const date = new Date();
        const dateString = `${date.getMonth() + 1}월 ${date.getDate()}일`;

        const listItem = document.createElement('li');
        listItem.textContent = `${title} | ${dateString}`;

        memoItems.appendChild(listItem);

        memoTitle.value = '';
        memoContent.value = '';
    });
});