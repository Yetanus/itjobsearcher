-- Add title & role
ALTER TABLE t_offer
ADD offertitle VARCHAR(255) NOT NULL,
ADD role VARCHAR(255) NOT NULL;