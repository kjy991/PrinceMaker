package com.makers.princemaker.dto;

import com.makers.princemaker.type.PrinceLevel;
import com.makers.princemaker.type.SkillType;
import lombok.*;

/**
 * @author Snow
 */
public class EditPrince {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private PrinceLevel princeLevel;
        private SkillType skillType;
        private Integer experienceYears;
        private String name;
        private Integer age;

        public Integer getAge() {
            return age;
        }

        public Integer getExperienceYears() {
            return experienceYears;
        }

        public String getName() {
            return name;
        }

        public PrinceLevel getPrinceLevel() {
            return princeLevel;
        }

        public SkillType getSkillType() {
            return skillType;
        }

        public void setPrinceLevel(PrinceLevel princeLevel) {
            this.princeLevel = princeLevel;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setExperienceYears(Integer experienceYears) {
            this.experienceYears = experienceYears;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSkillType(SkillType skillType) {
            this.skillType = skillType;
        }
    }
}
