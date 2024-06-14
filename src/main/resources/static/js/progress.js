document.addEventListener('DOMContentLoaded', () => {
    const courseSelect = document.getElementById('courseSelect');
    const gradeSelect = document.getElementById('gradeSelect');
    const progressBar = document.getElementById('progress-bar');

    courseSelect.addEventListener('change', () => {
        gradeSelect.disabled = false;
        updateProgressBar([]);
    });

    gradeSelect.addEventListener('change', () => {
        const courseId = courseSelect.value;
        const grade = gradeSelect.value;
        if (courseId && grade) {
            fetch(`/api/progress/${courseId}/${grade}`)
                .then(response => response.json())
                .then(data => updateProgressBar(data))
                .catch(error => console.error('Error fetching progress data:', error));
        } else {
            console.log(("성공했는데 분명...?"))
            updateProgressBar([]);
        }
    });

    function updateProgressBar(sections) {
        progressBar.innerHTML = '';
        sections.forEach((section, sectionIndex) => {
            const segment = document.createElement('div');
            segment.className = 'progress-segment';
            segment.style.backgroundColor = section.completed ? '#90ee90' : `rgba(0, 0, 0, ${0.3 + sectionIndex * 0.3})`;
            segment.innerText = `${section.section} ${section.subSection}`;
            segment.dataset.sectionId = section.id;
            segment.dataset.originalColor = segment.style.backgroundColor;
            segment.addEventListener('click', () => {
                const isCompleted = segment.style.backgroundColor === 'rgb(144, 238, 144)';
                const newColor = isCompleted ? segment.dataset.originalColor : '#90ee90';
                segment.style.backgroundColor = newColor;

                // 서버에 업데이트 요청 보내기
                fetch('/api/progress/update', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        id: segment.dataset.sectionId,
                        completed: !isCompleted
                    })
                }).catch(error => console.error('Error updating progress:', error));
            });
            progressBar.appendChild(segment);
        });
    }
});
