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

            modelBuilder.Entity<WorksheetExerciseEntity>(entity =>
            {
                entity.ToTable("worksheet_exercise");
                entity.HasKey(e => e.Id);
            });
        }
    }
}
