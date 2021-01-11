EXPLAIN ANALYSE
SELECT *
FROM towns
Where name='e61fa2ff3f46c30dd600d0287c941945';

CREATE INDEX idx_towns_name ON towns(name);
CREATE INDEX idx_towns_name ON towns(article);
CREATE INDEX idx_towns_name ON towns(code);

DROP INDEX IF EXISTS idx_towns_name;

EXPLAIN ANALYSE
SELECT *
FROM towns
Where id='457';

SELECT
    tablename,
    indexname,
    indexdef
FROM
    pg_indexes
WHERE
        schemaname = 'public'
ORDER BY
    tablename,
    indexname;