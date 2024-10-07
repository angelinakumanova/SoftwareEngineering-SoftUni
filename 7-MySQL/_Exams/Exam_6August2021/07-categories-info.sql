SELECT c.name, COUNT(*) AS games_count, ROUND(AVG(g.budget), 2) AS avg_budget, MAX(g.rating) AS max_rating
FROM games_categories gc
JOIN games g ON gc.game_id = g.id
JOIN categories c ON gc.category_id = c.id
GROUP BY c.name
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.name;