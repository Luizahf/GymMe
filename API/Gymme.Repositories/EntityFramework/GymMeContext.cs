using Gymme.Repositories.Entities;
using Microsoft.EntityFrameworkCore;

namespace Gymme.Repositories.EntityFramework
{
    internal class GymMeContext : DbContext
    {
        public DbSet<UserEntity> UserEntity { get; set; }
        public DbSet<MetricsEntity> MetricsEntity { get; set; }
        public DbSet<ExerciseEntity> ExerciseEntity { get; set; }
        public DbSet<PracticeEntity> PracticeEntity { get; set; }
        public DbSet<WorksheetEntity> WorksheetEntity { get; set; }
        public DbSet<WorksheetExerciseEntity> WorksheetExerciseEntity { get; set; }
        public DbSet<WorksheetExerciseMetricsEntity> WorksheetExerciseMetricsEntity { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseMySQL("server=localhost;database=gymme;user=root;password=amora01");
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<ExerciseEntity>(entity =>
            {
                entity.ToTable("exercise");
                entity.HasKey(e => e.Id);
            });

            modelBuilder.Entity<UserEntity>(entity =>
            {
                entity.ToTable("users");
                entity.HasKey(e => e.Id);
            });

            modelBuilder.Entity<WorksheetEntity>(entity =>
            {
                entity.ToTable("worksheet");
                entity.HasKey(e => e.Id);
                entity.Property(s => s.Description).HasColumnName("description");
                entity.Property(s => s.PracticeId).HasColumnName("id_practice");
            });

            modelBuilder.Entity<WorksheetExerciseEntity>(entity =>
            {
                entity.ToTable("worksheet_exercise");
                entity.HasKey(e => e.Id);
                entity.Property(s => s.ExerciseId).HasColumnName("id_exercise");
                entity.Property(s => s.WorksheetId).HasColumnName("id_worksheet");
            });

            modelBuilder.Entity<WorksheetExerciseMetricsEntity>(entity =>
            {
                entity.ToTable("worksheet_exercise_metrics");
                entity.HasKey(e => e.Id);
                entity.Property(s => s.MetricsId).HasColumnName("id_metrics");
                entity.Property(s => s.WorksheetExerciseId).HasColumnName("id_worksheet_exercise");
            });

            modelBuilder.Entity<MetricsEntity>(entity =>
            {
                entity.ToTable("metrics");
                entity.HasKey(e => e.Id);
                entity.Property(s => s.Series).HasColumnName("series");
                entity.Property(s => s.Repetitions).HasColumnName("repetitions");
                entity.Property(s => s.Load).HasColumnName("load");
                entity.Property(s => s.ExecutionTime).HasColumnName("execution_time");
            });

            modelBuilder.Entity<PracticeEntity>(entity =>
            {
                entity.ToTable("practice");
                entity.HasKey(e => e.Id);
                entity.Property(s => s.Description).HasColumnName("description");
                entity.Property(s => s.Goal).HasColumnName("goal");
                entity.Property(s => s.DueDate).HasColumnName("due_date");
                entity.Property(s => s.Frequency).HasColumnName("frequency");
                entity.Property(s => s.UserId).HasColumnName("id_user");
            });
        }
    }
}
