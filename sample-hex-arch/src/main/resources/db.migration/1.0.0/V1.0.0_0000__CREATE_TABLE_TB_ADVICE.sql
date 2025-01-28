CREATE TABLE IF NOT EXISTS tb_advice
(
    "id" TEXT NOT NULL,
    "advice_slip_id" INTEGER NOT NULL,
    "advice_text" TEXT NOT NULL,
    "created_at" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(3) NOT NULL,

    CONSTRAINT "tb_advice_pkey" PRIMARY KEY ("id")
)