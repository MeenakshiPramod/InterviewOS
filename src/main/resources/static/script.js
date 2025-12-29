// -------------------------------
// Global State
// -------------------------------
let lastFailedProblemId = null;
let solvedProblems = new Set();

// -------------------------------
// Load all problems into sidebar
// -------------------------------
function loadProblems() {
    fetch('/problems')
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById('problemList');
            list.innerHTML = '';

            data.forEach(p => {
                const solvedClass = solvedProblems.has(p.problemId) ? 'solved' : '';

                list.innerHTML += `
                    <div class="problem-item ${solvedClass}">
                        <div class="problem-title">${p.title}</div>
                        <div class="problem-meta">
                            Difficulty: ${p.difficulty}
                        </div>
                        <div class="tags">
                            ${p.tags.map(tag => `<span class="tag">${tag}</span>`).join('')}
                        </div>
                        <div>
                            <button onclick="fail(${p.problemId})">Fail</button>
                            <button onclick="solve(${p.problemId})">Mark Solved</button>
                        </div>
                    </div>
                `;
            });
        });
}

// -------------------------------
// User FAILED a problem
// -------------------------------
function fail(problemId) {
    lastFailedProblemId = problemId;

    fetch(`/attempt?problemId=${problemId}&solved=false&timeTaken=600`, {
        method: 'POST'
    }).then(() => {
        loadRecommendations();
    });
}

// -------------------------------
// User SOLVED a problem
// -------------------------------
function solve(problemId) {
    solvedProblems.add(problemId);

    fetch(`/attempt?problemId=${problemId}&solved=true&timeTaken=200`, {
        method: 'POST'
    }).then(() => {
        loadProblems();        // update sidebar state
        loadRecommendations(); // update recommendations
    });
}

// -------------------------------
// Load recommendations
// -------------------------------
function loadRecommendations() {
    if (lastFailedProblemId === null) return;

    fetch(`/recommend?failedProblemId=${lastFailedProblemId}&k=6`)
        .then(res => res.json())
        .then(data => {
            const rec = document.getElementById('recommendations');
            rec.innerHTML = '';

            if (data.length === 0) {
                rec.innerHTML = `<p>No recommendations available.</p>`;
                return;
            }

            data.forEach(p => {
                rec.innerHTML += `
                    <div class="card">
                        <h3>${p.title}</h3>
                        <p>Difficulty: ${p.difficulty}</p>
                        <div class="tags">
                            ${p.tags.map(tag => `<span class="tag">${tag}</span>`).join('')}
                        </div>
                        <button onclick="solve(${p.problemId})">Mark Solved</button>
                    </div>
                `;
            });
        });
}

// -------------------------------
// Initial load
// -------------------------------
loadProblems();
