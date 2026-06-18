// Driver App — Main JavaScript

document.addEventListener('DOMContentLoaded', function () {

  // Auto-hide alerts after 5 seconds
  const alerts = document.querySelectorAll('.alert');
  alerts.forEach(alert => {
    setTimeout(() => {
      alert.style.transition = 'opacity 0.5s';
      alert.style.opacity = '0';
      setTimeout(() => alert.remove(), 500);
    }, 5000);
  });

  // Form loading state
  const forms = document.querySelectorAll('form');
  forms.forEach(form => {
    form.addEventListener('submit', function () {
      const btn = form.querySelector('button[type="submit"]');
      if (btn) {
        btn.disabled = true;
        btn.innerHTML = '<span class="spinner"></span> ' + (btn.dataset.loading || 'Загрузка...');
      }
    });
  });

  // Input focus animation
  const inputs = document.querySelectorAll('.form-input');
  inputs.forEach(input => {
    const group = input.closest('.form-group');
    if (group) {
      input.addEventListener('focus', () => group.classList.add('focused'));
      input.addEventListener('blur', () => group.classList.remove('focused'));
    }
  });

  // Animate elements on scroll
  const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        entry.target.style.opacity = '1';
        entry.target.style.transform = 'translateY(0)';
      }
    });
  }, { threshold: 0.1 });

  document.querySelectorAll('.card, .stat-card, .ride-card').forEach(el => {
    el.style.transition = 'opacity 0.4s ease, transform 0.4s ease';
    observer.observe(el);
  });
});
